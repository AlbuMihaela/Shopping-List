    package ShoppingList;

    public class Item {
        private String name;

        private Unit unit;

        public Item(String name, Unit unit) {
            this.name = name;
            this.unit = unit;
        }

        public Item(String name) {
            this.name = name;
            this.unit = Unit.PCS; // default value
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Unit getUnit() {
            return unit;
        }

        public void setUnit(Unit unit) {
            this.unit = unit;
        }

        public enum Unit {
            PCS, // pieces
            KG,
            GR,
            L,
            M
        }

        @Override
        public String toString() {
            return name + " " + unit.name().toLowerCase();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            return name.equals(item.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
