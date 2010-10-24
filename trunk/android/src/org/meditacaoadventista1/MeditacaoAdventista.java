package org.meditacaoadventista1;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.meditacaoadventista1.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.admob.android.ads.AdView;

public class MeditacaoAdventista extends Activity {
    public static String URL = "http://meditacaoadventistamobile.googlecode.com/svn/trunk/fs/";
    public static String URL_ADULTO = "adulto/";
    public static String URL_MULHER = "mulher/";
    public static String URL_JUVENIL = "juvenil/";
    private int currentLayout = 0;
	private String detailData = "";
	private String detailTitulo = "";
	private String detailVerso = "";
	private String detailConteudo = "";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	//com.admob.android.ads.AdManager.setTestDevices(new String[] {com.admob.android.ads.AdManager.TEST_EMULATOR, "E83D20734F72FB3108F104ABC0FFC738",});
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        currentLayout = R.layout.main;
        loadMain();
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
		setContentView(currentLayout);
		if (currentLayout == R.layout.main) {
			loadMain();
		} else if (currentLayout == R.layout.detail) {
    	  	((AdView)findViewById(R.id.ad)).setVisibility(AdView.VISIBLE);
			((TextView)findViewById(R.id.d)).setText(detailData);
			((TextView)findViewById(R.id.t)).setText(detailTitulo);
			((TextView)findViewById(R.id.v)).setText(detailVerso);
			((TextView)findViewById(R.id.c)).setText(detailConteudo);
			loadDetailBack();
		}
    }
    
    public void loadMain() {
    	((AdView)findViewById(R.id.ad)).setVisibility(AdView.VISIBLE);
        TextView alert = (TextView) findViewById(R.id.alert);
        InputStream is = null;        
        try {
        	String url = URL;
        	url = url.concat("alert.txt");
            URLConnection conn = new URL(url).openConnection();
            is = conn.getInputStream();
        	StringBuffer sbuffer = new StringBuffer();
            int b;
            while ((b = is.read()) != -1) {
                sbuffer.append((char)b);
            }
            String buffer = sbuffer.toString().trim();
        	if (buffer.indexOf("<android>") > -1 && buffer.indexOf("</android>") > -1) {
                alert.setText(buffer.substring(buffer.indexOf("<android>") + "<android>".length(), buffer.indexOf("</android>")));
            }
        } catch (Exception e) {
        	e.printStackTrace();
        	throw new Error(e);
        } finally {
        	if (is != null) {
        		try {
        			is.close();
        		} catch (Exception e) {
                	throw new Error(e);
                }
        	}
        }
        final DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        Button open = (Button)findViewById(R.id.open);
        open.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
            	String meditacaoData = "";
                String meditacaoTitulo = "";
                String meditacaoVerso = "";
                String meditacaoConteudo = "";
            	InputStream is = null;       
                try {
                	String url = URL;
                	if (radioGroup.getCheckedRadioButtonId() == R.id.mode_1) {
                		url = url.concat(URL_ADULTO);
                	} else if (radioGroup.getCheckedRadioButtonId() == R.id.mode_2) {
                		url = url.concat(URL_MULHER);
                	} else if (radioGroup.getCheckedRadioButtonId() == R.id.mode_3) {
                		url = url.concat(URL_JUVENIL);
                	}
                	url = url.concat(Integer.toString(datePicker.getYear())).concat("/");
                	url = url.concat(Integer.toString(datePicker.getYear()));
                    if (datePicker.getMonth() + 1 < 10) {
                    	url = url.concat("0").concat(Integer.toString(datePicker.getMonth() + 1));
                    } else {
                    	url = url.concat(Integer.toString(datePicker.getMonth() + 1));
                    }
                    if (datePicker.getDayOfMonth() < 10) {
                    	url = url.concat("0").concat(Integer.toString(datePicker.getDayOfMonth()));
                    } else {
                    	url = url.concat(Integer.toString(datePicker.getDayOfMonth()));
                    }
                    url = url.concat(".txt");
                    URLConnection conn = new URL(url).openConnection();
                    is = conn.getInputStream();
                	int b;
                    StringBuffer sbuffer = new StringBuffer();
                    boolean isOk = false;
                    while ((b = is.read()) != -1) {
                        switch (b) {
                            case 147:
                                sbuffer.append("\"");
                                break;
                            case 148:
                                sbuffer.append("\"");
                                break;
                            default:
                                sbuffer.append((char) b);
                                break;
                        }
                        String buffer = sbuffer.toString().trim();
                        if (buffer.startsWith("<d>") && buffer.endsWith("</d>")) {
                            meditacaoData = buffer.substring(3, buffer.length() - 4).trim();
                            sbuffer = new StringBuffer();
                        } else if (buffer.startsWith("<t>") && buffer.endsWith("</t>")) {
                            meditacaoTitulo = buffer.substring(3, buffer.length() - 4).trim();
                            sbuffer = new StringBuffer();
                        } else if (buffer.startsWith("<v>") && buffer.endsWith("</v>")) {
                            meditacaoVerso = buffer.substring(3, buffer.length() - 4).trim();
                            sbuffer = new StringBuffer();
                        } else if (buffer.startsWith("<c>") && buffer.endsWith("</c>")) {
                        	meditacaoConteudo = buffer.substring(3, buffer.length() - 4).trim();
                            sbuffer = new StringBuffer();
                            isOk = true;
                        }
                    }
                    if (!isOk || meditacaoData.equals("") || meditacaoTitulo.equals("") || meditacaoVerso.equals("") ) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    meditacaoData = "";
                    meditacaoTitulo = "N\u00E3o foi poss\u00EDvel carregar o conte\u00FAdo...";
                    meditacaoVerso = "";
                    meditacaoConteudo = e.toString();
                    e.printStackTrace();
                } finally {
                	if (is != null) {
                		try {
                			is.close();
                		} catch (Exception e) {
                        	throw new Error(e);
                        }
                	}
                }
                meditacaoConteudo = "    ".concat(meditacaoConteudo.replace("\n", "\n    "));
                setContentView(R.layout.detail);
                currentLayout = R.layout.detail;
                loadDetailBack();
                ((AdView)findViewById(R.id.ad)).setVisibility(AdView.VISIBLE);
            	TextView d = (TextView)findViewById(R.id.d);
            	TextView t = (TextView)findViewById(R.id.t);
            	TextView v = (TextView)findViewById(R.id.v);
            	TextView c = (TextView)findViewById(R.id.c);
            	d.setText(meditacaoData);
            	t.setText(meditacaoTitulo);
            	v.setText(meditacaoVerso);
            	c.setText(meditacaoConteudo);
            	detailData = meditacaoData;
            	detailTitulo = meditacaoTitulo;
            	detailVerso = meditacaoVerso;
            	detailConteudo = meditacaoConteudo;
            }
        });
        Button credit = (Button) findViewById(R.id.credit);
        credit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String url = "http://meditacaoadventistamobile.googlecode.com";
		        Intent i = new Intent(Intent.ACTION_VIEW);
		        i.setData(Uri.parse(url));
		        startActivity(i);
			}
        });
    }
    
    public void loadDetailBack() {
    	OnClickListener onClickListenerBack = new OnClickListener() {
            @Override
            public void onClick(View view) {
            	setContentView(R.layout.main);
            	currentLayout = R.layout.main;
            	loadMain();
            }
        };
        ((Button)findViewById(R.id.back1)).setOnClickListener(onClickListenerBack);
    	((Button)findViewById(R.id.back2)).setOnClickListener(onClickListenerBack);
    }
}