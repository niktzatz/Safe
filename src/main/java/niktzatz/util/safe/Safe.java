package niktzatz.util.safe;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Nikolaos D. Tzatzalas
 */
public class Safe
{
	public static String String(Object rootObject, String pathOfRequestedAttribute) throws RuntimeException
	{
		return (String) genericGet(rootObject, pathOfRequestedAttribute);
	}
	
	public static Integer Integer(Object rootObject, String pathOfRequestedAttribute) throws RuntimeException
	{
		return (Integer) genericGet(rootObject, pathOfRequestedAttribute);
	}
	
	public static Boolean Boolean(Object rootObject, String pathOfRequestedAttribute) throws RuntimeException
	{
		return (Boolean) genericGet(rootObject, pathOfRequestedAttribute);
	}
	
	public static Long Long(Object rootObject, String pathOfRequestedAttribute) throws RuntimeException
	{
		return (Long) genericGet(rootObject, pathOfRequestedAttribute);
	}
	
	public static BigDecimal BigDecimal(Object rootObject, String pathOfRequestedAttribute) throws RuntimeException
	{
		return (BigDecimal) genericGet(rootObject, pathOfRequestedAttribute);
	}
	
	public static Date Date(Object rootObject, String pathOfRequestedAttribute) throws RuntimeException
	{
		return (Date) genericGet(rootObject, pathOfRequestedAttribute);
	}
	
	public static Timestamp Timestamp(Object rootObject, String pathOfRequestedAttribute) throws RuntimeException
	{
		return (Timestamp) genericGet(rootObject, pathOfRequestedAttribute);
	}
	
	
	
	private static Object genericGet(Object rootObject, String pathOfRequestedAttribute) throws RuntimeException
	{
		String[] methods = pathOfRequestedAttribute.split("\\."); 
		Object curObject = rootObject;
		Method curMethod;
		String method = null;
		
		for(int i = 0; i < methods.length; ++i)
		{
			method = methods[i].substring(0, methods[i].length()-2);
			try
			{
				curMethod = curObject.getClass().getDeclaredMethod(method);
				curObject = curMethod.invoke(curObject);
			}
			catch(NullPointerException e)
			{
				return null;               
			}
			catch(Exception e)
			{
				throw new RuntimeException(e); 
			}			
		}
				
		return curObject;          
	}
}
