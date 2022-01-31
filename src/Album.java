class Album {
	//Atributos
	Pagina[] page;
	int selected;
	int pages;
	int x;
	int y;

	// ========== Construtores ==========
	Album(int x, int y, int pages) {
		page = new Pagina[pages];
		selected = 0;
		this.pages = 0;
		this.x = x;
		this.y = y;
	}

	// ========== Visualizar Página seguinte ==========
	ColorImage showNextPage() {
		if (selected + 1 == pages)
			throw new IllegalStateException("Está na última página.");
		selected++;
		if (page[selected] == null)
			throw new NullPointerException("Página vazia.");
		return page[selected].doPage();
	}

	// ========== Visualizar Página anterior ==========
	ColorImage showPreviousPage() {
		if (selected - 1 < 0)
			throw new IllegalStateException("Está na primeira página.");
		selected--;
		if (page[selected] == null)
			throw new NullPointerException("Página vazia.");
		return page[selected].doPage();
	}

	// ========== Visualizar Página atual ==========
	ColorImage showPage() {
		return page[selected].doPage();
	}

	// ========== Alterar posição de duas páginas ==========
	void changePagesPosition(int n, int m) {
		if (n < 1 || n > pages)
			throw new IllegalArgumentException("Posição " + n + " não existe, por favor escolha uma imagem de 1 a " + pages + ".");
		if (m < 1 || m > pages)
			throw new IllegalArgumentException("Posição " + m + " não existe, por favor escolha uma imagem de 1 a " + pages + ".");
		Pagina aux = page[n - 1];
		page[n - 1] = page[m - 1];
		page[m - 1] = aux;
	}

	// ========== Adicionar Página ao Álbum ==========
	void addNewPage(Pagina newPage) {
		if (newPage == null)
			throw new NullPointerException("Pagina vazia.");
		if (pages != 10) {
			Pagina[] pagina = new Pagina[page.length + 1];
			for(int i = 0; i != pages; i++)
				pagina[i] = page[i];
			page = pagina;
		}
		else if (pages == 10)
			throw new IllegalStateException("Não há mais espaço no Album.");
		page[pages] = newPage;
		pages++;
	}
}
