public class HouseBuilder implements HousingBuilder {
    protected House house = new House();

    public HouseBuilder setSize(int size) {
        house.setSize(size);
        return this;
    }

    public HouseBuilder setPrice(int price) {
        house.setPrice(price);
        return this;
    }

    public HouseBuilder setRooms(int rooms) {
        house.setRooms(rooms);
        return this;
    };

    public HouseBuilder setName(String name) {
        house.setName(name);
        return this;
    };

    public House build() {
        return house;
    }
}