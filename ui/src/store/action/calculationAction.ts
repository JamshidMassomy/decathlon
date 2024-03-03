import { eventApi } from '../../api/calculations';
import { ACTION } from '../../util/constants';

export const fetchCalculations =
  ({ result, sport }) =>
  (dispatch: (arg0: { type: string; payload: any }) => void) => {
    eventApi
      .fetchCalculations(result, sport)
      .then((data) => {
        dispatch({
          type: ACTION.FETCH_CALCULATIONS,
          payload: { data, sport },
        });
      })
      .catch((error) => {
        dispatch({ type: ACTION.FETCH_FAIL_CALCULATIONS, payload: error });
      });
  };
