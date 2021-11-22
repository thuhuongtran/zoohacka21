export interface Activism {
  author: string;
  category: string;
  date: string;
  image: string;
  link: string;
  subtitle: string;
  title: string;
}
export interface ActivismResponse {
  count: number;
  data: Activism[];
}
