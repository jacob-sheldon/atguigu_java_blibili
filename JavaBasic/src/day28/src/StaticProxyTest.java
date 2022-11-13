interface ClothFactory {
    void produceCloths();
}

class ProxyClothFactory implements ClothFactory {
    public ClothFactory concreteFactory;

    public ProxyClothFactory(ClothFactory concreteFactory) {
        this.concreteFactory = concreteFactory;
    }

    @Override
    public void produceCloths() {
        System.out.println("生产前做的准备工作");
        this.concreteFactory.produceCloths();
        System.out.println("生产后做的收尾工作");
    }
}

class NikeFactory implements ClothFactory {


    @Override
    public void produceCloths() {
        System.out.println("Nike 工厂生产服装");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nikeFactory = new NikeFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nikeFactory);
        proxyClothFactory.produceCloths();
    }
}
