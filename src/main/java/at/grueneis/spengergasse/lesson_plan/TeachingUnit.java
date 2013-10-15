package at.grueneis.spengergasse.lesson_plan;

import java.util.UUID;

public class TeachingUnit {

	private final UUID uuid;
	private final String nameEins;

	public TeachingUnit(String name) {
		uuid = UUID.randomUUID();
		this.nameEins = name;
	}

	public String getNameEins() {
		return nameEins.toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeachingUnit other = (TeachingUnit) obj;
		if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	public String dumpObject() {
		return "Iahh [uuid=" + uuid + ", nameEins=" + nameEins + "]";
	}

	@Override
	public String toString() {
		return "Iahh [uuid=" + uuid + "]";
	}
}
