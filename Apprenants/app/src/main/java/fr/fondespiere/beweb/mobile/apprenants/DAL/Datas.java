package fr.fondespiere.beweb.mobile.apprenants.DAL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespiere.beweb.mobile.apprenants.DAL.enumerations.Status;

/**
 * Created by jc on 05/07/17.
 */

public class Datas {

    public static JSONObject apprenant;


    public static JSONArray getApprenants() throws JSONException {
        JSONArray apprenants = new JSONArray();
        JSONObject alex = new JSONObject();
        JSONObject jc = new JSONObject();
        JSONObject marie = new JSONObject();

        alex.putOpt("id",1);
        alex.putOpt("nom","Le forestier");
        alex.putOpt("prenom","Alexandre");
        alex.putOpt("age","30");
        alex.putOpt("promo",1);
        alex.putOpt("session",1);
        alex.putOpt("status", Status.Chomage);

        jc.putOpt("id",2);
        jc.putOpt("nom","Petetin");
        jc.putOpt("prenom","Jean-Christian");
        jc.putOpt("age","2017");
        jc.putOpt("promo",1);
        jc.putOpt("session",1);
        jc.putOpt("status",Status.Formation);

        marie.putOpt("id",3);
        marie.putOpt("nom","Urbano");
        marie.putOpt("prenom","Marie");
        marie.putOpt("age","5");
        marie.putOpt("promo",2);
        marie.putOpt("session",1);
        marie.putOpt("status",Status.Formation);

        apprenants.put(alex);
        apprenants.put(jc);
        apprenants.put(marie);

        return apprenants;
    }

    public static JSONObject getApprenant(int id) throws JSONException {
        //creation de l'objet apprenant
        JSONObject apprenant = new JSONObject();
        //recuperation de tout les apprenants
        JSONArray apprenants = Datas.getApprenants();
        //on boucle dans la liste des apprenants
        for (int i=0;i<apprenants.length();i++){
            //on verifie que l'apprenant correspond bien a l'id
            if (apprenants.getJSONObject(i).getInt("id") == id){
                //on stocke l'apprenant dans l'objet
                apprenant = apprenants.getJSONObject(i);
                //on recupere les skills et le projets et on les stocke dans l'objet apprenant
                apprenant.putOpt("skills",Datas.getSkills(id));
                apprenant.putOpt("projets",Datas.getProjets(id));
            }
        }
        return apprenant;
    }


    public static JSONArray getPromotion() throws JSONException {
        JSONArray promotion = new JSONArray();
        JSONObject lunel1 = new JSONObject();
        JSONObject lunel2 = new JSONObject();
        JSONObject beziers1 = new JSONObject();

        lunel1.putOpt("id",1);
        lunel1.putOpt("ville","Lunel");
        lunel1.putOpt("session",1);

        lunel2.putOpt("id",2);
        lunel2.putOpt("ville","Lunel");
        lunel2.putOpt("session",2);

        beziers1.putOpt("id",3);
        beziers1.putOpt("ville","Beziers");
        beziers1.putOpt("session",1);

        promotion.put(lunel1);
        promotion.put(lunel2);
        promotion.put(beziers1);

        return promotion;
    }

    public static JSONArray getProjets() throws JSONException {
        JSONArray projets = new JSONArray();
        JSONObject adopteUnPatron = new JSONObject();
        JSONObject pizzaioli = new JSONObject();
        JSONObject bewebV1 = new JSONObject();
        JSONObject bewebV2 = new JSONObject();

        adopteUnPatron.putOpt("id",1);
        adopteUnPatron.putOpt("nomProjet","adopteUnPatron");
        adopteUnPatron.putOpt("apprenant",1);
        adopteUnPatron.putOpt("siteWeb","www.adopteUnPatron.fr");
        adopteUnPatron.putOpt("description","blablabla");

        pizzaioli.putOpt("id",2);
        pizzaioli.putOpt("nomProjet","pizzaioli");
        pizzaioli.putOpt("apprenant",2);
        pizzaioli.putOpt("siteWeb","www.pizzaioli.fr");
        pizzaioli.putOpt("description","blebleble");

        bewebV1.putOpt("id",3);
        bewebV1.putOpt("nomProjet","bewebV1");
        bewebV1.putOpt("apprenant",1);
        bewebV1.putOpt("siteWeb","www.bewebV1.fr");
        bewebV1.putOpt("description","bliblibli");

        bewebV2.putOpt("id",4);
        bewebV2.putOpt("nomProjet","bewebV2");
        bewebV2.putOpt("apprenant",3);
        bewebV2.putOpt("siteWeb","www.bewebV2.fr");
        bewebV2.putOpt("description","blobloblo");

        projets.put(adopteUnPatron);
        projets.put(pizzaioli);
        projets.put(bewebV1);
        projets.put(bewebV2);

        return projets;
    }

    public static JSONArray getProjets(int apprenantID) throws JSONException {
        JSONArray projets = Datas.getProjets();
        JSONArray projetsApprenant = new JSONArray();
        for (int i=0;i<projets.length();i++){
            if (projets.getJSONObject(i).getInt("apprenant") == apprenantID){
                projetsApprenant.put(projets.getJSONObject(i));
            }
        }
        return projetsApprenant;
    }

    public static JSONArray getSkills() throws JSONException {
        JSONArray skills = new JSONArray();
        JSONObject html = new JSONObject();
        JSONObject css = new JSONObject();
        JSONObject javascript = new JSONObject();
        JSONObject php = new JSONObject();

        html.putOpt("id",1);
        html.putOpt("nom","html");
        html.putOpt("apprenant",1);
        html.putOpt("level",0.7);

        css.putOpt("id",2);
        css.putOpt("nom","css");
        css.putOpt("apprenant",1);
        css.putOpt("level",0.8);

        javascript.putOpt("id",3);
        javascript.putOpt("nom","javascript");
        javascript.putOpt("apprenant",2);
        javascript.putOpt("level",0.6);

        php.putOpt("id",4);
        php.putOpt("nom","php");
        php.putOpt("apprenant",3);
        php.putOpt("level",0.7);

        skills.put(html);
        skills.put(css);
        skills.put(javascript);
        skills.put(php);

        return skills;
    }

    public static JSONArray getSkills(int apprenantID) throws JSONException {
        JSONArray skills = Datas.getSkills();
        JSONArray skillsApprenant = new JSONArray();
        for (int i=0;i<skills.length();i++){
            if(skills.getJSONObject(i).getInt("apprenant") == apprenantID){
                skillsApprenant.put(skills.getJSONObject(i));
            }
        }
        return skillsApprenant;
    }
}
