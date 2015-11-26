package ulti.domain.gametype;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GameTypeConverter {

	private static final Map<Integer, ConcreteGameType> gameTypeMap = new HashMap<Integer, ConcreteGameType>();

	public GameTypeConverter() {
		final ConcreteGameType concreteGameTypeParty = new ConcreteGameType(
				"Parti", 0, 1, true, true, false, true);
		concreteGameTypeParty.getGameTypeList().add(new GameTypeParty());
		gameTypeMap.put(1, concreteGameTypeParty);
	}

	public static Map<Integer, ConcreteGameType> getGametypemap() {
		return gameTypeMap;
	}

	public ConcreteGameType convertIntToConcreteGameType(final int key) {
		return gameTypeMap.get(key);
	}

	public int convertConcreteGameTypeToInt(
			final ConcreteGameType concreteGameType) {
		if (concreteGameType != null) {
			for (final Entry<Integer, ConcreteGameType> entry : gameTypeMap
					.entrySet()) {
				if (concreteGameType.getName().equals(
						entry.getValue().getName())) {
					return entry.getKey();
				}
			}
		}

		return 0;
	}
}
