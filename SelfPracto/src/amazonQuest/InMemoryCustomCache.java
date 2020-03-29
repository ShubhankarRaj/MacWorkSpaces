package amazonQuest;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.LRUMap;

import java.util.ArrayList;

public class InMemoryCustomCache<K, T> {
    private long timeToLive;
    private LRUMap cacheMap;

    protected class CacheObject{
        public long lastAccessed = System.currentTimeMillis();
        public T value;

        protected CacheObject(T value){
            this.value = value;
        }

    }

    public InMemoryCustomCache(long timeToLive, final long timerInterval, int maxItems){
        this.timeToLive = timeToLive *  1000;
        cacheMap = new LRUMap(maxItems);

        if((timeToLive > 0) && (timerInterval > 0)) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try{
                            Thread.sleep(timerInterval * 1000);
                        } catch(InterruptedException e){}
                        cleanup();
                    }

                }
            });

            t.setDaemon(true);
            t.start();
        }
    }

    public void put(K key, T value){
        synchronized (cacheMap){
            cacheMap.put(key, new CacheObject(value));
        }
    }

    public T get(K key){
        synchronized (cacheMap){
            CacheObject obj = (CacheObject)cacheMap.get(key);

            if(obj == null)
                return null;
            else{
                obj.lastAccessed = System.currentTimeMillis();
                return obj.value;
            }
        }
    }

    public void remove(K key){
        synchronized(cacheMap){
            cacheMap.remove(key);
        }
    }

    public int size(){
        synchronized (cacheMap){
            return cacheMap.size();
        }
    }

    public void cleanup(){
        long now = System.currentTimeMillis();
        ArrayList<K> deleteKeys = null;

        synchronized (cacheMap){
            MapIterator itr = cacheMap.mapIterator();
            K key = null;
            CacheObject obj = null;
            while(itr.hasNext()){
                key = (K) itr.next();
                obj = (CacheObject) itr.getValue();

                if(obj != null && (now > (timeToLive + obj.lastAccessed))){
                    cacheMap.remove(key);
                }
            }

            Thread.yield();
        }

    }
}
