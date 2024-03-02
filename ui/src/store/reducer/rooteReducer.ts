import { combineReducers } from 'redux';
import sportReducer from './sportReducer';
import calculationsReducer from './calculationsReducer';

const rootReducer = combineReducers({
  sports: sportReducer,
  calculation: calculationsReducer,
});

export default rootReducer;
