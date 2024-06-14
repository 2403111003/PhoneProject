package Pp.M;

import Pp.M.C.Cart;
import Pp.M.I.Item;
import Pp.M.U.Admin;
import Pp.M.U.Customer;

public class Model {
	Cart C;
	Customer CM; 
	Admin A;
	Item I;
	public Model(Cart c,Customer cm,Admin a,Item i) {
		this.C = c;
		this.CM = cm;
		this.A = a;
		this.I = i;
	}
	public void getItemList() {
		I.getItemList();
	}
}
