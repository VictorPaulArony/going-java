class DriverFactory {
    public static Driver getDriver(String s) {
        if (s.equals("Car")) {
            return new CarDriver();
        } else if (s.equals("Plane")) {
            return new PlaneDriver();
        }
        return null;
    }

}