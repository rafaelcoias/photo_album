class Image {

	// ========== Colar Imagem(img) em cima de outra imagem(backImg) ==========

	static void validatePaste(ColorImage img, ColorImage backImg) {
		int imgW = img.getWidth();
		int imgH = img.getHeight();
		int backImgW = backImg.getWidth();
		int backImgH = backImg.getHeight();
		if ((backImgW < imgW && backImgH > imgH) || (backImgW > imgW && backImgH < imgH))
			throw new IllegalArgumentException("Imagem é maior que a imagem de fundo.");
	}

	static void pasteImage(ColorImage img, ColorImage backImg, int x, int y) {
		validatePaste(img, backImg);
		for (int i = x, imgx = 0; i < x + img.getWidth() && i != backImg.getWidth(); i++, imgx++) {
			for (int j = y, imgy = 0; j < y + img.getHeight() && j != backImg.getHeight(); j++, imgy++) {
				Color c = img.getColor(imgx, imgy);
				if (!(c.isWhite()))
					backImg.setColor(i, j, c);
			}
		}
	}

	// ========== Criar Imagem de Fundo da Página ==========

	static ColorImage doBackGroundImage(ColorImage img, int x, int y) {
		ColorImage fundo = new ColorImage(x, y);
		for (int i = 0; i != x; i++)
			for (int j = 0; j != y; j++)
				fundo.setColor(i, j, Color.WHITE);
		for (int i = 0; i < x; i += img.getWidth())
			for (int j = 0; j < y; j += img.getHeight())
				pasteImage(img, fundo, i, j);
		return fundo;
	}

	// ========== Aumentar ou Diminuir Imagem ==========

	static ColorImage scale(ColorImage img, double scl) {
		ColorImage bImg = new ColorImage((int)(img.getWidth() * scl), (int)(img.getHeight() * scl));
		for (int i = 0; i != bImg.getWidth(); i++)
			for (int j = 0; j != bImg.getHeight(); j++)
				bImg.setColor(i, j, img.getColor((int)(i / scl), (int)(j / scl)));
		return bImg;
	}

	// ========== Fazer efeito de Imagem Cinza ==========

	static ColorImage grayImage(ColorImage img) {
		for (int x = 0; x != img.getWidth(); x++)
			for (int y = 0; y != img.getHeight(); y++)
				img.setColor(x, y, img.getColor(x, y).doGray());
		return img;
	}

	// ========== Fazer efeito de Vignette ==========
	
	static ColorImage vignette(ColorImage img, int radius) {
		int x = img.getWidth() / 2;
		int y = img.getHeight() / 2;
		for (int i = 0; i != img.getWidth(); i++) {
			for (int j = 0; j != img.getHeight(); j++) {
				int dist = (int)(Math.sqrt(Math.pow((x - i), 2)+Math.pow((y - j), 2)));
				if (dist >= radius) {
					Color c = img.getColor(i, j).changeBrightness((dist - radius) * -1);
					img.setColor(i, j, c);
				}
			}
		}
		return img;
	}
}