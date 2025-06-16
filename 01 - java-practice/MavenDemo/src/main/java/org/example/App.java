package org.example;
import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 * Convention over Configuration
 * Convention Based Framework - how you name things and where you put them matters
 * if you follow the Convention, then everything works each time
 *
 * Configuration is where you are manually setting up your configuration, which
 * can cause problems.
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String text = "    Hello Maven!    ";

        String trimmed = StringUtils.strip(text);
        String reversed = StringUtils.reverse(trimmed);

        System.out.println("Original: '" + text + "'");
        System.out.println("Trimmed: '" + trimmed + "'");
        System.out.println("Reversed: '" + reversed + "'");
    }
}
