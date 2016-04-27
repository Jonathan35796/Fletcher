package scripts.BloodsAirCharger.Banking;

import org.tribot.api.General;

import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSItem;
import scripts.BloodsAirCharger.Task;

/**
 * Created by Andrew on 11/19/2015.
 */ 
public class DepositItems extends Task {
	@Override
	public void execute() {
		depositVial();
		depositOrbs();
	}

	@Override
	public boolean validate() {
		return Banking.isInBank() && Banking.isBankScreenOpen() && Inventory.getCount("Air orb","Vial") > 0;
	}

	@Override
	public int priority() {
		return 3;
	}

	@Override
	public String status() {
		return "Depositing items";
	}

	public static void depositOrbs(){
		RSItem orbs[] = Inventory.find("Air orb");
		if(orbs.length > 0){
			if(Banking.depositItem(orbs[0],0)){
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						General.sleep(200,500);
						return Inventory.getCount("Air orb") == 0;
					}
				},5000);
			}
		}
	}

	public static void depositVial(){
		RSItem vials[] = Inventory.find("Vial");
		if(vials.length > 0){
			if(Banking.deposit(1,"Vial")){
				Timing.waitCondition(new Condition() {
					@Override
					public boolean active() {
						General.sleep(50,200);
						return Inventory.getCount("Vial") == 0;
					}
				},5000);
			}
		}
	}
}
