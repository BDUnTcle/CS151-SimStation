package simstation;
import mvc.Utilities;

public class Heading {
	public enum HeadingText {
		NORTH, SOUTH, EAST, WEST
	}
	private HeadingText text;
	public static  Heading random()
	{
		return new Heading();
	}
	public static HeadingText randomText() {
		int heading = Utilities.rng.nextInt(3);
		switch (heading)
		{
			case 0:

				return HeadingText.NORTH;
			case 1:
				return HeadingText.SOUTH;
			case 2:
				return HeadingText.EAST;
			case 3:
				return HeadingText.WEST;
		}
		return HeadingText.NORTH;
	}

	public Heading()
	{
		text = randomText();
	}

	public HeadingText getHeading() {
		return text;
	}
}
