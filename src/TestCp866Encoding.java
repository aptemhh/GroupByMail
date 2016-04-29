import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class TestCp866Encoding {

    public static void main(String[] args) {

        try {
            SortedMap<String,Charset> registeredCharsets = Charset.availableCharsets();
            for ( Iterator<Charset> charsets = registeredCharsets.values().iterator(); charsets.hasNext(); ) {
                Charset charset = charsets.next();
                // Display name
                System.out.print(charset.name() + " Aliases: [");
                // Display aliases
                for ( Iterator<String> aliases = charset.aliases().iterator(); aliases.hasNext(); ) {
                    System.out.print(aliases.next());
                    if ( aliases.hasNext() ) System.out.print(", ");
                }
                System.out.println("]");
            }


            System.out.println("\nIs cp1125 supported? - " + Charset.isSupported("1125")); // testing aliase
            System.out.println("Is IBM866 supported? - " + Charset.isSupported("IBM866"));
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }

}