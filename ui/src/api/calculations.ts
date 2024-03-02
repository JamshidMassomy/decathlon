import toast from 'react-hot-toast';
import { _fetch } from '.';
import { BASE_URL } from '../util/constants';

const fetchCalculations = (result: number, sport: string): Promise<any[]> => {
  return _fetch()
    .get(`${BASE_URL}/calculate-points?sport=${sport}&result=${result}`)
    .catch(() => {
      toast('Error happend while fetching data');
    });
};

const fetchSportTypes = (): Promise<any[]> => {
  return _fetch()
    .get(`${BASE_URL}/sports`)
    .catch(() => {
      toast('Error happend while fetching data');
    });
};

export const eventApi = {
  fetchCalculations,
  fetchSportTypes,
};
