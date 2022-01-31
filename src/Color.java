class Color {
	private final int[] rgb; // @color

	static final Color RED = new Color(255, 0, 0);
	static final Color GREEN= new Color(0, 255, 0);
	static final Color BLUE = new Color(0, 0, 255);
	static final Color WHITE = new Color(255, 255, 255);
	static final Color BLACK = new Color(0, 0, 0);
	static final Color CYAN = new Color(0, 255, 255);
	static final Color MAGENTA = new Color(255, 0, 255);
	static final Color ORANGE = new Color(255, 127, 0);

	Color(int r, int g, int b) {
		if(!valid(r) || !valid(g) || !valid(b))
			throw new IllegalArgumentException("invalid RGB values: " + r + ", " + g + ", " + b);
		this.rgb = new int[] {r, g, b};
	}

	int getR() {
		return rgb[0];
	}

	int getG() {
		return rgb[1];
	}

	int getB() {
		return rgb[2];
	}

	int getLuminance() {
		return (int) Math.round(rgb[0]*.21 + rgb[1]*.71 + rgb[2]*.08);
	}

	static boolean valid(int value) {
		return value >= 0 && value <= 255;
	}

	// ========== Extras ==========

	//Mudar a cor para Gray
	Color doGray() {
		int gray = (int)((0.3 * getR()) + (0.59 * getG()) + (0.11 * getB()));
		return new Color(gray, gray, gray);
	}

	//Confirmar se o valor ultrapassa os limites de RGB
	int valid(int n, int delta) {
		if (n + delta < 0)
			return 0;
		if (n + delta > 255)
			return 255;
		return n + delta;
	}

	//Ver se delta é maior ou igual a 0, se for então por o delta = 0
	int checkDelta(int delta) {
		return delta >= 0 ? 0 : delta;
	}

	//Mudar o brilho da cor
	Color changeBrightness(int delta) {
		delta = checkDelta(delta);
		return new Color(valid(getR(), delta), valid(getG(), delta), valid(getB(), delta));
	}
	
	//Verificar transparência
	boolean isWhite() {
		return getR() == 255 && getG() == 255 && getB() == 255;
	}
}