import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            var continents = new ContinentDAO();
            var countries = new CountryDAO();
            var cities = new CityDAO();

            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader("c:\\Users\\blkma\\Desktop\\Repo\\JavaLabs\\Lab8\\src\\res\\concap.csv"));

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] tempArr = line.split(",");

                    String countryName = tempArr[0];
                    String capitalName = tempArr[1];
                    double capitalLatitude = Double.parseDouble(tempArr[2]);
                    double capitalLongitude = Double.parseDouble(tempArr[3]);
                    String countryCode = tempArr[4];
                    String continentName = tempArr[5];

                    Continent continent = new Continent(continentName);

                    if (continents.findByName(continentName) == null) {
                        continents.create(continent);
                    }

                    Country country = new Country(countryName, countryCode, continentName);

                    if (countries.findByName(countryName) == null) {
                        countries.create(country);
                    }

                    City city = new City(capitalName, countryName, true, capitalLatitude, capitalLongitude);

                    if (cities.findByName(capitalName) == null) {
                        cities.create(city);
                    }

                    Database.getConnection().commit();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            // Display the distances between various cities in the world
            DistanceCalculator distanceCalculator = new DistanceCalculator();

            City city1 = cities.findByName("Bucharest");
            City city2 = cities.findByName("Paris");

            System.out.println("Display the distances between various cities in the world:");
            System.out.println("Distance from " + city1.getName() + " to " + city2.getName() + " is: " + distanceCalculator.displayDistances(city1, city2));

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
