class tests {
	static ColorImage[] testImageClass() {
		ColorImage image = new ColorImage("src/fotos/mario.png");
		ColorImage testScale = Image.scale(new ColorImage("src/fotos/mario.png"), 0.5);
		ColorImage testGray = Image.grayImage(new ColorImage("src/fotos/mario.png"));
		ColorImage testVignette = Image.vignette(new ColorImage("src/fotos/mario.png"), 100);
		
		ColorImage[] v = {image, testScale, testGray, testVignette};
		return v;
	}

	static Foto[] testFotoClass() {
		Foto f1 = new Foto(new ColorImage("src/fotos/capa.png"), "ping floyd", "09/12/21");
		Foto f2 = new Foto(new ColorImage("src/fotos/mario.png"), "mario", "10/12/21");
		
		Foto[] v = {f1, f2};
		return v;
	}

	static Pagina testClassPagina() {
		Foto f1 = new Foto(new ColorImage("src/fotos/objc1.png"), "botas", "07/12/21");
		Foto f2 = new Foto(Image.scale(new ColorImage("src/fotos/jesus.png"), 0.5), "jesus", "08/12/21");
		Foto f3 = new Foto(new ColorImage("src/fotos/capa.png"), "ping floyd", "09/12/21");
		Foto f4 = new Foto(Image.vignette(new ColorImage("src/fotos/padrao.png"), 30), "padrao", "10/12/21");
		
		Pagina p1 = new Pagina(new Foto(new ColorImage("src/fotos/mario.png"), "mario", "10/12/21"), 800, 800);
		
		p1.changeBackGround(Image.scale(new ColorImage("src/fotos/capa.png"), 0.2));
		
		p1.addNewFoto(f1);
		p1.addNewFoto(f2);
		p1.addNewFoto(f3);
		p1.addNewFoto(f4);

		return p1;
	}
	
	static Pagina testClassPagina2() {
		Foto f1 = new Foto(new ColorImage("src/fotos/objc1.png"), "botas", "07/12/21");
		Foto f2 = new Foto(Image.scale(new ColorImage("src/fotos/jesus.png"), 0.5), "jesus", "08/12/21");
		Foto f3 = new Foto(new ColorImage("src/fotos/capa.png"), "ping floyd", "09/12/21");
		Foto f4 = new Foto(new ColorImage("src/fotos/mario.png"), "mario", "10/12/21");
		Foto f5 = new Foto(Image.vignette(new ColorImage("src/fotos/padrao.png"), 30), "padrao", "10/12/21");
		Foto f6 = new Foto(Image.vignette(new ColorImage("src/fotos/padrao.png"), 30), "padrao", "10/12/21");
		Foto f7 = new Foto(Image.vignette(new ColorImage("src/fotos/padrao.png"), 30), "padrao", "10/12/21");
		Foto f8 = new Foto(Image.vignette(new ColorImage("src/fotos/padrao.png"), 30), "padrao", "10/12/21");
		
		Pagina p2 = new Pagina(new ColorImage[] {f1.img, f2.img, f3.img, f4.img}, 800, 800);

		p2.changeBackGround(Image.scale(new ColorImage("src/fotos/padrao.png"), 0.2));
		
		p2.addNewFoto(f5);
		p2.addNewFoto(f6);
		p2.addNewFoto(f7);
		p2.addNewFoto(f8);
		
		return p2;
	}
	
	static Pagina testClassPagina3() {
		Foto f1 = new Foto(new ColorImage("src/fotos/objc1.png"), "botas", "07/12/21");
		Foto f2 = new Foto(Image.scale(new ColorImage("src/fotos/jesus.png"), 0.5), "jesus", "08/12/21");
		Foto f3 = new Foto(new ColorImage("src/fotos/capa.png"), "ping floyd", "09/12/21");
		Foto f4 = new Foto(new ColorImage("src/fotos/mario.png"), "mario", "10/12/21");
		Foto f5 = new Foto(Image.vignette(new ColorImage("src/fotos/padrao.png"), 30), "padrao", "10/12/21");
		
		Pagina p3 = new Pagina(new ColorImage[] {f1.img, f2.img, f3.img, f4.img}, 800, 800);

		p3.changeBackGround(Image.scale(new ColorImage("src/fotos/mario.png"), 0.2));
		
		p3.addNewFoto(f5);
		
		return p3;
	}

	static Album testAlbum() {
		Pagina p1 = testClassPagina();
		Pagina p2 = testClassPagina2();
		Pagina p3 = testClassPagina3();
		
		Album a = new Album(1000, 700, 5);
		
		a.addNewPage(p1);
		a.addNewPage(p2);
		a.addNewPage(p3);
		
		return a;
	}
}