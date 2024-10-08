
interface Visitor {
    void visitTShirt(TShirtProduct tshirt);
    void visitJeans(JeansProduct jeans);
}

interface VisitableProduct {
    void accept(Visitor visitor);
}

class TShirtProduct implements VisitableProduct {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitTShirt(this);
    }
}

class JeansProduct implements VisitableProduct {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitJeans(this);
    }
}

class DiscountVisitor implements Visitor {
    @Override
    public void visitTShirt(TShirtProduct tshirt) {
        System.out.println("Знижка на футболку");
    }

    @Override
    public void visitJeans(JeansProduct jeans) {
        System.out.println("Знижка на джинси");
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        TShirtProduct tshirt = new TShirtProduct();
        JeansProduct jeans = new JeansProduct();
        Visitor discountVisitor = new DiscountVisitor();

        tshirt.accept(discountVisitor);
        jeans.accept(discountVisitor);
    }
}
