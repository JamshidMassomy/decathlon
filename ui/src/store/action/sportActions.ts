import { eventApi } from '../../api/calculations';
import { ACTION } from '../../util/constants';

export const fetchSportTypes = () => (dispatch) => {
  eventApi
    .fetchSportTypes()
    .then((data) => {
      dispatch({ type: ACTION.FETCH_SPORT, payload: data });
    })
    .catch((error) => {
      dispatch({ type: ACTION.FETCH_FAIL_SPORT, payload: error });
    });
};
