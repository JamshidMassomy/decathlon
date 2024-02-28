import toast from 'react-hot-toast';
import { _fetch } from '.';
import { BASE_URL } from '../util/constants';

const fetchCalculations = async (): Promise<any[]> => {
  return _fetch()
    .get(BASE_URL)
    .catch(() => {
      toast('Error happend while fetching data');
    });
};

export const eventApi = {
  fetchCalculations,
};
