import { Disc } from "../disc/disc";

export interface Boxset {
    id: number;
    title: string;
    discs: Set<Disc>;
}