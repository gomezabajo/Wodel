package wodeledu.utils.manager;

import java.util.List;
import java.util.Random;

public class WodelEduManager {
	
	public static Random rn = new Random((int) System.currentTimeMillis());
	
	/**
	 * @param l
	 *            List in order to get the size and index
	 * @return Random number
	 */
	public static int getRandomIndex(List<?> l) {
		if (l.size() <= 1)
			return 0;

		int index = rn.nextInt() % l.size();
		if (index < 0)
			index = index * -1;

		return index;
	}

}
