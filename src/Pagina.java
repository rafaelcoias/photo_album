class Pagina {
	//Atributos
	ColorImage page;
	ColorImage pattern;
	Foto[] foto;
	int next = 0;

	// ========== Construtores ==========
	Pagina (Foto newFoto, int x, int y) {
		if (newFoto == null)
			throw new NullPointerException("Imagem vazia.");
		page = new ColorImage(x, y);
		pattern = new ColorImage(x, y);
		foto = new Foto[5];
		foto[next] = newFoto;
		next++;
	}

	Pagina (ColorImage[] fotos, int x, int y) {
		page = new ColorImage(x, y);
		pattern = new ColorImage(x, y);
		foto = new Foto[fotos.length];
		for (int i = 0; i != fotos.length && i != foto.length && fotos[i] != null; i++) {
			foto[next] = new Foto(fotos[i], "", "");
			next++;
		}
	}

	// ========== Alterar fundo da página ==========
	void changeBackGround(ColorImage pattern) {
		this.pattern = pattern;
		page = Image.doBackGroundImage(pattern, page.getWidth(), page.getHeight());
	}

	// ========== Adicionar Foto à página ==========
	void addNewFoto(Foto newFoto) {
		if (newFoto == null)
			throw new NullPointerException("Imagem vazia.");
		if (next == foto.length && foto.length != 10) {
			Foto[] foto2 = new Foto[foto.length * 2];
			for(int i = 0; i != foto.length; i++)
				foto2[i] = foto[i];	
			foto = foto2;
		}
		else if (next == 10)
			throw new IllegalStateException("Não há mais espaço na página.");
		foto[next] = newFoto;
		next++;
		doPage();
	}

	// ========== Organizar a página ==========
	void organizePage() {
		for (int i = 0; i != next && i != foto.length - 1; i++) {
			if (foto[i] == null && foto[i + 1] != null) {
				foto[i] = foto[i + 1];
				foto[i + 1] = null;
			}
		}
		next--;
	}

	// ========== Remover foto da página ==========
	void removeFoto(int n) {
		if (n < 1 || n > next)
			throw new IllegalArgumentException("Posição " + n + " não existe ou não há fotos nessa posição, por favor escolha uma imagem de 1 a " + next + ".");
		foto[n - 1] = null;
		organizePage();
		doPage();
	}

	// ========== Alterar posição de duas fotos ==========
	void changePosition(int n, int m) {
		if (n < 1 || n > next)
			throw new IllegalArgumentException("Posição " + n + " não existe ou não há fotos nessa posição, por favor escolha uma imagem de 1 a " + next + ".");
		if (m < 1 || m > next)
			throw new IllegalArgumentException("Posição " + m + " não existe ou não há fotos nessa posição, por favor escolha uma imagem de 1 a " + next + ".");
		Foto aux = foto[n - 1];
		foto[n - 1] = foto[m - 1];
		foto[m - 1] = aux;
		doPage();
	}

	// ========== Cálcular posição na Página ==========
	void calculatePosition() {
		int n = 0;
		for (int max = 5, y = max; n != next && foto[n] != null; y += 5 + max) {
			for (int x = 5; n != next && foto[n] != null && x + foto[n].img.getWidth() <= page.getWidth() - 6; x += 5 + foto[n - 1].img.getWidth()) {
				foto[n].changeLocation(x, y);
				if (n + 1 != foto.length && foto[n + 1] != null)
					max = Math.max(max, Math.max(foto[n+1].img.getHeight(), foto[n].img.getHeight()));
				n++;
			}
		}
	}

	// ========== Fazer e visualizar página ==========
	ColorImage doPage() {
		changeBackGround(pattern);
		calculatePosition();
		for (int i = 0; i != next; i++)
			Image.pasteImage(foto[i].img, page, foto[i].x, foto[i].y);
		return page;
	}
}
