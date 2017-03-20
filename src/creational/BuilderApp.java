package creational;

public class BuilderApp {
    public static void main(String[] args){
        Water cola = new Water.ColaBuilder()
                .name("Cola")
                .sugar(true)
                .sodium(true)
                .build();

        Water colaLight = new Water.ColaBuilder()
                .name("Cola Light")
                .sugar(false)
                .sodium(false)
                .build();

        System.out.println("Состав: " + cola.getName() + "\nСахар: " + cola.isSuger() + "\nНатрий: " + cola.isSodium());
        System.out.println("Состав: " + colaLight.getName() + "\nСахар: " + colaLight.isSuger() + "\nНатрий: " + colaLight.isSodium());


    }
}


 class Water {
    private String name;
    private boolean suger;
    private boolean sodium;

    private Water(ColaBuilder colaBuilder) {
        this.name = colaBuilder.name;
        this.suger = colaBuilder.sugar;
        this.sodium = colaBuilder.sodium;
    }

    public String getName() {
        return name;
    }

    public boolean isSuger() {
        return suger;
    }

    public boolean isSodium() {
        return sodium;
    }


    static class ColaBuilder {
        private String name;
        private boolean sugar;
        private boolean sodium;

        public ColaBuilder name(String name) {
            this.name = name;
            return this;
        }

        ColaBuilder sugar(boolean sugar) {
            this.sugar = sugar;
            return this;
        }

        ColaBuilder sodium(boolean sodium) {
            this.sodium = sodium;
            return this;
        }

        public Water build() {
            return new Water(this);
        }

    }
}