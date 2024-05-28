package ComponentesCustoms;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CustomTable extends JTable {

    public CustomTable() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
