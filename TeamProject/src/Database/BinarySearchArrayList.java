package Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class BinarySearchArrayList {
	private final static int NOT_FOUND = -1;
    public int binarySearch(ArrayList<String> stringList, String searchValue) {

        int low = 0;
        int high = stringList.size();
        int mid = (low + high) / 2;
        

        while (low <= high && !stringList.get(mid).equalsIgnoreCase(searchValue)) {
            if (stringList.get(mid).compareTo(searchValue) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = (low + high) / 2;

            if (low > high) {
                mid = NOT_FOUND;
                JOptionPane.showMessageDialog(null, "No data of that name exist!!", "warning", JOptionPane.WARNING_MESSAGE);
            }

        }
        
        return mid;

    }

}
