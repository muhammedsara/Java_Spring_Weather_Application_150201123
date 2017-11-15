//Muhammed ŞARA 150201123
package com.example.springvaadin;

import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button.ClickListener;

import java.util.ArrayList;
import java.util.List;

@SpringUI
@Theme("valo")
public class ScreenUI extends UI{

	@Autowired
	private Service service;
	private Weather weather;
	private Weather weatherd;
	
	@Override
	protected void init(VaadinRequest request) {
		Label label25 =new Label("Muhammed ŞARA");




		// List of planets
		List<String> province = new ArrayList<>();
		province.add(new String("Adana"));
		province.add(new String("Adıyaman"));
		province.add(new String("Afyonkarahisar"));
		province.add(new String("Ağrı"));
		province.add(new String("Amasya"));
		province.add(new String("Ankara"));
		province.add(new String("Antalya"));
		province.add(new String("Artvin"));
		province.add(new String("Aydın"));
		province.add(new String("Balıkesir"));


		province.add(new String("Bilecik"));
		province.add(new String("Bingöl"));
		province.add(new String("Bitlis"));
		province.add(new String("Bolu"));
		province.add(new String("Burdur"));
		province.add(new String("Bursa"));
		province.add(new String("Çanakkale"));
		province.add(new String("Çankırı"));
		province.add(new String("Çorum"));
		province.add(new String("Denizli"));

		province.add(new String("Diyarbakır"));
		province.add(new String("Edirne"));
		province.add(new String("Elazığ"));
		province.add(new String("Erzincan"));
		province.add(new String("Erzurum"));
		province.add(new String("Eskişehir"));
		province.add(new String("Gaziantep"));
		province.add(new String("Giresun"));
		province.add(new String("Gümüşhane"));
		province.add(new String("Hakkâri"));

		province.add(new String("Hatay"));
		province.add(new String("Isparta"));
		province.add(new String("Mersin"));
		province.add(new String("İstanbul"));
		province.add(new String("İzmir"));
		province.add(new String("Kars"));
		province.add(new String("Kastamonu"));
		province.add(new String("Kayseri"));
		province.add(new String("Kırklareli"));
		province.add(new String("Kırşehir"));

		province.add(new String("Kocaeli"));
		province.add(new String("Konya"));
		province.add(new String("Kütahya"));
		province.add(new String("Malatya"));
		province.add(new String("Manisa"));
		province.add(new String("Kahramanmaraş"));
		province.add(new String("Mardin"));
		province.add(new String("Muğla"));
		province.add(new String("Muş"));
		province.add(new String("Nevşehir"));

		province.add(new String("Niğde"));
		province.add(new String("Ordu"));
		province.add(new String("Rize"));
		province.add(new String("Sakarya"));
		province.add(new String("Samsun"));
		province.add(new String("Siirt"));
		province.add(new String("Sinop"));
		province.add(new String("Sivas"));
		province.add(new String("Tekirdağ"));
		province.add(new String("Tokat"));

		province.add(new String("Trabzon"));
		province.add(new String("Tunceli"));
		province.add(new String("Şanlıurfa"));
		province.add(new String("Uşak"));
		province.add(new String("Van"));
		province.add(new String("Yozgat"));
		province.add(new String("Zonguldak"));
		province.add(new String("Aksaray"));
		province.add(new String("Bayburt"));
		province.add(new String("Karaman"));

		province.add(new String("Kırıkkale"));
		province.add(new String("Batman"));
		province.add(new String("Şırnak"));
		province.add(new String("Bartın"));
		province.add(new String("Ardahan"));
		province.add(new String("Iğdır"));
		province.add(new String("Yalova"));
		province.add(new String("Karabük"));
		province.add(new String("Kilis"));
		province.add(new String("Osmaniye"));
		province.add(new String("Düzce"));

		ComboBox<String> select =new ComboBox<>("Tr - İl Seçiniz");
		select.setItems(province);

		TextField name = new TextField("Diğer Yerler İçin :");
		//TextField name2 = new TextField("İl Seçimi Yapınız:");



		//Button button3=new Button("örnek-ekle");
		Button send = new Button("Tr - GÖNDER");
		Button sendd = new Button("Diğer - GÖNDER");

		//	Button button2 = new Button("Receive");
		Label label = new Label(" Türkiye İlleri İçin Hava Durumu");
		Label label_ad =new Label("Secilen İl  ---");
		Label label1 = new Label("Sıcaklık     ---");
		Label label2 = new Label("Basınç       ---");
		Label label3 = new Label("Nem          ---");
		Label label4 = new Label("Hava         ---");

		Label labeld = new Label("Diğer İller İçin Hava Durumu ");
		Label labeld_ad =new Label("Secilen İl  ---");
		Label label1d = new Label("Sıcaklık     ---");
		Label label2d = new Label("Basınç       ---");
		Label label3d = new Label("Nem          ---");
		Label label4d = new Label("Hava         ---");



		HorizontalLayout leftTop =new HorizontalLayout(label25);
		VerticalLayout leftMenu =new VerticalLayout(label25,name,sendd,select,send);
		VerticalLayout rightMenu =new VerticalLayout(label,label_ad,label1,label2,label3,label4);
		VerticalLayout right=new VerticalLayout(labeld,labeld_ad,label1d,label2d,label3d,label4d);
		HorizontalLayout main=new HorizontalLayout(leftTop,leftMenu,rightMenu,right);

		main.setMargin(true);
		main.setMargin(true);
		setContent(main);


			//Varsıyılan olarak
		weather = service.getWeather("Erzurum");
		label_ad.setValue(String.valueOf("Seçilen İl -> "+"Erzurum"));
		label1.setValue(String.valueOf("Sıcaklık -> "+weather.getMain().getTemp()) + " °C");
		label2.setValue(String.valueOf("Basınc -> "+weather.getMain().getPressure()) + " p");
		label3.setValue(String.valueOf("Nem -> "+weather.getMain().getHumidity()) + " %");
		int bas=weather.property.toString().indexOf("main=");
		bas=bas+5;
		int bit=weather.property.toString().indexOf(", description");
		label4.setValue(String.valueOf("Hava -> "+weather.property.toString().substring(bas,bit)) + "");



		weatherd = service.getWeather("İsviçre");
		labeld_ad.setValue(String.valueOf("Seçilen İl -> "+"İsviçre"));
		label1d.setValue(String.valueOf("Sıcaklık -> "+weatherd.getMain().getTemp()) + " °C");
		label2d.setValue(String.valueOf("Basınc -> "+weatherd.getMain().getPressure()) + " p");
		label3d.setValue(String.valueOf("Nem -> "+weatherd.getMain().getHumidity()) + " %");
		int bas2=weather.property.toString().indexOf("main=");
		bas2=bas2+5;
		int bit2=weather.property.toString().indexOf(", description");
		label4d.setValue(String.valueOf("Hava -> "+weather.property.toString().substring(bas2,bit2)) + "");


		send.addClickListener(new ClickListener(){
			private static final long serialVersionUID = -8424487726640573041L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				weather = service.getWeather(select.getValue());
				label_ad.setValue(String.valueOf("Seçilen İl -> "+select.getValue()));
				label1.setValue(String.valueOf("Sıcaklık -> "+weather.getMain().getTemp()) + " °C");
				label2.setValue(String.valueOf("Basınc -> "+weather.getMain().getPressure()) + " p");
				label3.setValue(String.valueOf("Nem -> "+weather.getMain().getHumidity()) + " %");
				int bas=weather.property.toString().indexOf("main=");
				bas=bas+5;
				int bit=weather.property.toString().indexOf(", description");
				label4.setValue(String.valueOf("Hava -> "+weather.property.toString().substring(bas,bit)) + "");

				//label2.setValue(String.valueOf(weather.getMain().getTemp()) + "°C");

			}
		});



		sendd.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent clickEvent) {

				weatherd = service.getWeather(name.getValue());
				labeld_ad.setValue(String.valueOf("Seçilen İl -> "+name.getValue()));
				label1d.setValue(String.valueOf("Sıcaklık -> "+weatherd.getMain().getTemp()) + " °C");
				label2d.setValue(String.valueOf("Basınc -> "+weatherd.getMain().getPressure()) + " p");
				label3d.setValue(String.valueOf("Nem -> "+weatherd.getMain().getHumidity()) + " %");
				int x;
				int bas=weather.property.toString().indexOf("main=");
				bas=bas+5;
				int bit=weather.property.toString().indexOf(", description");
				label4d.setValue(String.valueOf("Hava -> "+weather.property.toString().substring(bas,bit)) + "");

			}
		});


	}

}
