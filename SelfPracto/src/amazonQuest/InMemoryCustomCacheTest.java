package amazonQuest;

public class InMemoryCustomCacheTest {
    public static void main(String[] args) {
        InMemoryCustomCacheTest cachetTest = new InMemoryCustomCacheTest();
        cachetTest.addRemoveObjectTest();

    }

    private void addRemoveObjectTest(){
        InMemoryCustomCache<String, String> cache = new InMemoryCustomCache<>(100, 10, 6);
        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");
        cache.put("Google", "Google");
        cache.put("Microsoft", "Microsoft");
        cache.put("IBM", "IBM");
        cache.put("Facebook", "Facebook");

        System.out.println("6 Cache Object Added.. cache.size(): " + cache.size());
        cache.remove("IBM");
        System.out.println("One object removed.. cache.size(): " + cache.size());

        cache.put("Twitter", "Twitter");
        cache.put("SAP", "SAP");
        System.out.println("Two objects Added but reached maxItems.. cache.size(): " + cache.size());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Total objects left in the cache" + cache.size());

    }
}
