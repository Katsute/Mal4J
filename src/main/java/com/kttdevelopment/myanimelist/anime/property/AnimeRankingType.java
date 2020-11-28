package com.kttdevelopment.myanimelist.anime.property;

import com.kttdevelopment.myanimelist.property.RankingType;

public enum AnimeRankingType {

    Airing  ("airing"),
    Upcoming("upcoming"),

    TV      ("tv"),
    OVA     ("ova"),
    Movie   ("movie"),
    Special ("special"),

    All         (RankingType.All.field()),
    ByPopularity(RankingType.ByPopularity.field()),
    Favorite    (RankingType.Favorite.field());

    private final String field;

    AnimeRankingType(final String type){
        this.field = type;
    }

    public final String field(){
        return field;
    }

    public static AnimeRankingType asEnum(final String string){
        for(final AnimeRankingType value : values())
            if(value.field.equalsIgnoreCase(string))
                return value;
        return null;
    }

    @Override
    public final String toString(){
        return name();
    }

}
