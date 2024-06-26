package com.example.dotalens.model


import com.google.gson.annotations.SerializedName

class AllHeroesState : ArrayList<AllHeroesState.AllHeroesStateItem>(){
    data class AllHeroesStateItem(
        @SerializedName("agi_gain")
        val agiGain: Double,
        @SerializedName("attack_point")
        val attackPoint: Double,
        @SerializedName("attack_range")
        val attackRange: Int,
        @SerializedName("attack_rate")
        val attackRate: Double,
        @SerializedName("attack_type")
        val attackType: String,
        @SerializedName("base_agi")
        val baseAgi: Int,
        @SerializedName("base_armor")
        val baseArmor: Int,
        @SerializedName("base_attack_max")
        val baseAttackMax: Int,
        @SerializedName("base_attack_min")
        val baseAttackMin: Int,
        @SerializedName("base_attack_time")
        val baseAttackTime: Int,
        @SerializedName("base_health")
        val baseHealth: Int,
        @SerializedName("base_health_regen")
        val baseHealthRegen: Double,
        @SerializedName("base_int")
        val baseInt: Int,
        @SerializedName("base_mana")
        val baseMana: Int,
        @SerializedName("base_mana_regen")
        val baseManaRegen: Double,
        @SerializedName("base_mr")
        val baseMr: Int,
        @SerializedName("base_str")
        val baseStr: Int,
        @SerializedName("cm_enabled")
        val cmEnabled: Boolean,
        @SerializedName("day_vision")
        val dayVision: Int,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("img")
        val img: String,
        @SerializedName("int_gain")
        val intGain: Double,
        @SerializedName("legs")
        val legs: Int,
        @SerializedName("localized_name")
        val localizedName: String,
        @SerializedName("move_speed")
        val moveSpeed: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("night_vision")
        val nightVision: Int,
        @SerializedName("primary_attr")
        val primaryAttr: String,
        @SerializedName("pro_ban")
        val proBan: Int,
        @SerializedName("pro_pick")
        val proPick: Int,
        @SerializedName("pro_win")
        val proWin: Int,
        @SerializedName("projectile_speed")
        val projectileSpeed: Int,
        @SerializedName("pub_pick")
        val pubPick: Int,
        @SerializedName("pub_pick_trend")
        val pubPickTrend: List<Int>,
        @SerializedName("pub_win")
        val pubWin: Int,
        @SerializedName("pub_win_trend")
        val pubWinTrend: List<Int>,
        @SerializedName("roles")
        val roles: List<String>,
        @SerializedName("str_gain")
        val strGain: Double,
        @SerializedName("turbo_picks")
        val turboPicks: Int,
        @SerializedName("turbo_picks_trend")
        val turboPicksTrend: List<Int>,
        @SerializedName("turbo_wins")
        val turboWins: Int,
        @SerializedName("turbo_wins_trend")
        val turboWinsTrend: List<Int>,
        @SerializedName("turn_rate")
        val turnRate: Double,
    )
}