package aaa.game.facility.button;

import aaa.game.component.button.ButtonSideTemplate;
import aaa.game.constv.ConstVar;
import aaa.game.data.ShareData;
import aaa.game.facility.hammer.screen.HammerScreen;
import aaa.game.facility.home.screen.HomeScreen;
import aaa.game.facility.market.screen.MarketScreen;
import aaa.game.facility.school.screen.SchoolScreen;
import aaa.game.mainframe.MainFrame;

public class FacilitySideButtonFactory {
	public static ButtonSideTemplate getCitySideButton(final String facilityId) {
		ButtonSideTemplate buttonSideTemplate = new ButtonSideTemplate() {
			@Override
			public void doClick() {
				// TODO Auto-generated method stub
				if (facilityId.equals(ConstVar.Facility.FACILITY_ID_PRE
						+ "00104")) {
					MainFrame.pushScreen(new HomeScreen(
							ConstVar.Facility.FACILITY_ID_PRE + "00104"));
				}
				if (facilityId.equals(ConstVar.Facility.FACILITY_ID_PRE
						+ "00105")) {
					MainFrame.pushScreen(new HammerScreen(
							ConstVar.Facility.FACILITY_ID_PRE + "00105"));
				}
				if (facilityId.equals(ConstVar.Facility.FACILITY_ID_PRE
						+ "00101")) {
					MainFrame.pushScreen(new MarketScreen(
							ConstVar.Facility.FACILITY_ID_PRE + "00101"));
				}
				
				if (facilityId.equals(ConstVar.Facility.FACILITY_ID_PRE
						+ "00102")) {
					MainFrame.pushScreen(new SchoolScreen(
							ConstVar.Facility.FACILITY_ID_PRE + "00102"));
				}
			}
		};
		buttonSideTemplate.setText(ShareData.facilities.get(facilityId,
				ConstVar.Facility.NAME_KEY));
		return buttonSideTemplate;
	}
}
