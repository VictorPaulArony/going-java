public class ApartmentBuilder implements HousingBuilder {
    protected Apartment apartment = new Apartment();

    @Override
    public ApartmentBuilder setSize(int size) {
        apartment.setSize(size);
        return this;
    }

    public ApartmentBuilder setPrice(int price) {
        apartment.setPrice(price);
        return this;
    }

    public ApartmentBuilder setRooms(int rooms) {
        apartment.setRooms(rooms);
        return this;
    };

    public ApartmentBuilder setName(String name) {
        apartment.setName(name);
        return this;
    };

    public Apartment build() {
        return apartment;
    }
}