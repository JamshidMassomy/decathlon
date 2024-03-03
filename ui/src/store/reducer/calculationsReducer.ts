import { ACTION } from '../../util/constants';
import initialState from '../initialstate';

export default function calculationsReducer(state = initialState, action: any) {
  console.log('actions', action);
  switch (action.type) {
    case ACTION.FETCH_CALCULATIONS:
      return {
        ...state,
        point: action.payload.data.point,
        sport: action.payload.sport,
      };

    case ACTION.FETCH_FAIL_CALCULATIONS:
      return {
        ...state,
        point: -1,
        sport: null,
        error: action.payload,
      };

    default:
      return state;
  }
}
