import { eventApi } from '../../api/calculations';
import { ACTION } from '../../util/constants';

export const fetchCalculations = () => async (dispatch) => {
  await eventApi
    .fetchCalculations()
    .then((data) => {
      dispatch({ type: ACTION.FETCH_CALCULATIONS, payload: data });
    })
    .catch((error) => {
      dispatch({ type: ACTION.FETCH_CALCULATIONS, payload: error });
    });
};
