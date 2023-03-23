
/**
 * The Farm interface defines an farm property - cannot be instantiated but objects of type Farm can be declared
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public interface Farm
{
    /**
     * whereToLive - abstract prototype, to be overridden by classes inplementing the interface. If a class doesn't override this method then the 
     *               interface will be useless and we will just have an abstract clas
     * @param  none
     * @return String
     */
    public abstract String whereToLive();
}
