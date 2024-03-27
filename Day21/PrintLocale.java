import java.util.Locale;

public class PrintLocale {
    public static void main(final String... args) {
        var defaultLocale = Locale.getDefault();

        //printLocaleInformation(Locale.US);
        //printLocaleInformation(Locale.GERMANY);

        //Locale.setDefault(Locale.GERMANY);

        //printLocaleInformation(Locale.US);
        //printLocaleInformation(Locale.GERMANY);

        System.out.println(Locale.US.getDisplayCountry(Locale.FRANCE));
        System.out.println(Locale.US.getDisplayName(Locale.FRANCE));
    }
    public static void printLocaleInformation(final Locale locale) {
        System.out.println(locale);
        System.out.format("country: %s%n", locale.getCountry());
        System.out.format("display country: %s%n", locale.getDisplayCountry());
        System.out.format("display language: %s%n", locale.getDisplayLanguage());
        System.out.format("display name: %s%n", locale.getDisplayName());
        System.out.format("display script: %s%n", locale.getDisplayScript());
        System.out.format("display variant: %s%n", locale.getDisplayVariant());
        System.out.format("ISO3 country: %s%n", locale.getISO3Country());
        System.out.format("ISO3 language: %s%n", locale.getISO3Language());
        System.out.format("language: %s%n", locale.getLanguage());
        System.out.format("script: %s%n", locale.getScript());
        System.out.format("variant: %s%n", locale.getVariant());
        System.out.println();
    }
}
