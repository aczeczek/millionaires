package pl.annaczeczek.millionaires.external.cryptowatch.dto;

public class Summary {
    public Result result;

    public static class Result {

        public Price price;
        public Double volume;

        public static class Price {

            public Double last;
            public Double high;
            public Double low;
            public Change change;

            public static class Change {

                public Double percentage;
                public Double absolute;

                @Override
                public String toString() {
                    return "Change{" +
                            "percentage=" + percentage +
                            ", absolute=" + absolute +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "Price{" +
                        "last=" + last +
                        ", high=" + high +
                        ", low=" + low +
                        ", change=" + change +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Result{" +
                    "price=" + price +
                    ", volume=" + volume +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Summary{" +
                "result=" + result +
                '}';
    }
}
