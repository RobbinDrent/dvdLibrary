import { Film } from "../film/film";

export interface Disc {
    id: number;
    isDvd: boolean;
    description: string;
    distributor: string;
    film: Film;
}