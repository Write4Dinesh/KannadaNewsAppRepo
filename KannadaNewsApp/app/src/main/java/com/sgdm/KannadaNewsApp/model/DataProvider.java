package com.sgdm.KannadaNewsApp.model;

import android.content.Context;

import com.sgdm.KannadaNewsApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrinvigroup on 27/03/2018.
 */

public class DataProvider {

    public static List<KNANewsPaper> getNewsPapers(Context context) {
        List<KNANewsPaper> list = new ArrayList<>();

        list.add(new KNANewsPaper(context.getString(R.string.vk_button_label), context.getString(R.string.vk_url)));
        list.add(new KNANewsPaper(context.getString(R.string.kp_button_label), context.getString(R.string.kp_url)));
        list.add(new KNANewsPaper(context.getString(R.string.uv_button_label), context.getString(R.string.uv_url)));
        list.add(new KNANewsPaper(context.getString(R.string.pv_button_label), context.getString(R.string.pv_url)));
        list.add(new KNANewsPaper(context.getString(R.string.vv_button_label), context.getString(R.string.vv_url)));
        list.add(new KNANewsPaper(context.getString(R.string.sv_button_label), context.getString(R.string.sv_url)));
        list.add(new KNANewsPaper(context.getString(R.string.sk_button_label), context.getString(R.string.sk_url)));
        list.add(new KNANewsPaper(context.getString(R.string.kk_button_label), context.getString(R.string.kk_url)));
        list.add(new KNANewsPaper(context.getString(R.string.kr_button_label), context.getString(R.string.kr_url)));
        list.add(new KNANewsPaper(context.getString(R.string.kd_button_label), context.getString(R.string.kd_url)));
        list.add(new KNANewsPaper(context.getString(R.string.jm_button_label), context.getString(R.string.jm_url)));
        list.add(new KNANewsPaper(context.getString(R.string.pp_button_label), context.getString(R.string.pp_url)));
        list.add(new KNANewsPaper(context.getString(R.string.vb_button_label), context.getString(R.string.vb_url)));
        list.add(new KNANewsPaper(context.getString(R.string.sn_button_label), context.getString(R.string.sn_url)));
        list.add(new KNANewsPaper(context.getString(R.string.bn_button_label), context.getString(R.string.bn_url)));
        list.add(new KNANewsPaper(context.getString(R.string.jv_button_label), context.getString(R.string.jv_url)));
        list.add(new KNANewsPaper(context.getString(R.string.tc_button_label), context.getString(R.string.tc_url)));
        list.add(new KNANewsPaper(context.getString(R.string.wd_button_label), context.getString(R.string.wd_url)));
        list.add(new KNANewsPaper(context.getString(R.string.oi_button_label), context.getString(R.string.oi_url)));
        list.add(new KNANewsPaper(context.getString(R.string.vvn_button_label), context.getString(R.string.vvn_url)));
        return list;
    }
}
