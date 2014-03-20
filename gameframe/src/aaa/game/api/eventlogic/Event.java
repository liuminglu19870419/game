package aaa.game.api.eventlogic;

public class Event {
	private static class Signal {
		private static EventLogic eventLogic = null;
		private static EventInit eventInit = null;
		private static EventResult eventResult = null;
		static {
			eventInit = new EventInit();
			eventResult = new EventResult();
			eventLogic = new EventLogic();
		}
	}
}
