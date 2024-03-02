import { ACTION } from '../../util/constants';
import initialState from '../initialstate';

export default function calculationsReducer(state = initialState, action: any) {
  switch (action.type) {
    case ACTION.FETCH_CALCULATIONS:
      return {
        ...state,
        point: action.payload,
      };

    case ACTION.FETCH_CALCULATIONS:
      return {
        ...state,
        point: -1,
        error: action.payload,
      };

    default:
      return state;
  }
}
