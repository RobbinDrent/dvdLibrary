import { Director } from "../director/director";
import { Disc } from "../disc/disc";

export interface Film {
    id: number;
    title: string;
    releaseYear: number;
    displayTitle: string;
    directors: Set<Director>
    discs: Set<Disc>;
}