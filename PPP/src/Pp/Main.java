package Pp;

import java.io.IOException;

import Pp.C.Controller;
import Pp.M.Model;
import Pp.M.C.Cart;
import Pp.M.I.Item;
import Pp.M.U.Admin;
import Pp.M.U.Customer;
import Pp.V.View;

public class Main {
	public static void main(String agrs[]) throws IOException {
		Cart C = new Cart();
		Customer CM = new Customer(); 
		Admin A = new Admin();
		Item I = new Item();
		Model M = new Model(C, CM, A, I);
		View V = new View(M);
		Controller c = new Controller(V, M);
		c.Start();
	}
}
