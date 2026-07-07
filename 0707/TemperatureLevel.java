public  class TemperatureLevel{
    public static void main(String[] args) {
        double temperaturelevel = 30.0;

        if(temperaturelevel < 15){
            System.out.println("Cold");
        }else if(temperaturelevel >= 15 && temperaturelevel < 28){
            System.out.println("Warm");
        }else if(temperaturelevel >28){
            System.out.println("Hot");
        }
    }
}