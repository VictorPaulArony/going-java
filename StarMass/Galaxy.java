import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Galaxy{
    private List<CelestialObject> celestialObjects;

    public Galaxy(){
        celestialObjects=new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects(){
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject CelestialObject){
        celestialObjects.add(CelestialObject);
    }
    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Star", 0);
        map.put("Planet", 0);
        map.put("Other", 0);

        for (CelestialObject c : this.celestialObjects) {
            if (c instanceof Star) {
                int x = map.get("Star");
                map.put("Star", x + c.getMass()); 
            } else if (c instanceof Planet) {
                int x = map.get("Planet");
                map.put("Planet", x + c.getMass());
            } else {
                int x = map.get("Other");
                map.put("Other", x + c.getMass());
            }
        }

        return map;
    }

   
}