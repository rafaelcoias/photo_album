class Foto {
	//Atributos
	ColorImage img;
	String desc;
	String date;
	int x;
	int y;

	// ========== Construtores ==========
	Foto(ColorImage img, String desc, String date) {
		this.img = img;
		this.desc = desc;
		this.date = date;
		x = 0;
		y = 0;
	}
	
	// ========== Ver Informa��es da Foto ==========
	
	String showDescription() {
		return desc;
	}
	
	String showDate() {
		return date;
	}

	// ========== Alterar descri��o da foto ==========
	void changeDescription(String desc) {
		this.desc = desc;
	}

	// ========== Alterar data da foto ==========
	void changeDate(String date) {
		this.date = date;
	}

	// ========== Alterar localiza��o da foto ==========
	void changeLocation(int x, int y) {
		if (x < 0 || y < 0)
			new IllegalArgumentException("Posi��o inv�lida.");
		this.x = x;
		this.y = y;
	}
}