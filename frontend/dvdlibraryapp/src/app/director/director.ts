import { Film } from "../film/film";

export interface Director {
    id: number;
    firstName: string;
    infixName: string;
    lastName: string;
    dateOfBirt: number;
    country: string;
    films: Set<Film>;
}